package com.springapps.jpaexamples.orderapp;

import org.aspectj.lang.reflect.CatchClauseSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController// va fi o clasa din ultimul layer care face legatura cu clasele tip service
// si care prin intermediul http primesc comenzi si apot transmit comenzi prin json
@RequestMapping("orders")
public class OrderController {
    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping

    public ResponseEntity<List<Order>> findAll() {
        // ResponseEntity este o clasa generica care
        // ofera raspuns clientului prin intermediul http de tio  200 -> ok
        List<Order> orders = orderService.findAll();
        return ResponseEntity.ok(orders);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        //are rolul de a solicita date dintr o resursa specificata
        //parametrii metodei sunt adagati la adresa URL ca parametri de interogare si se poate folosi
        //pathVariable
            Order order = orderService.findById(id);
            return ResponseEntity.ok(order);
    }
    @GetMapping("{between}")
    public ResponseEntity<List<Order>> findByLocalDateBetween(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start, @RequestParam @DateTimeFormat (pattern = "yyyy-MM-dd") LocalDate end) {
        //convert String to formatDate
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate startDate = LocalDate.parse(start, formatter);
//        LocalDate endDate = LocalDate.parse(end, formatter);
        List<Order> orders = orderService.findOrderByLocalDateBetween(start, end);
        return ResponseEntity.ok(orders);


    }
    @PostMapping
    //are rolul de a trimite date pentru a fi procesate catre o resursa specificata
    //datele sunt trimise in corpul solicitarii adica in cazul nostru in postman pun un order
    // prin body -> raw pun detaliile comenzii
    public ResponseEntity<Order> addOrder(@RequestBody  Order order) {
        Order saveOrder = orderService.addOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable Long id) {
        Order updateOrder = orderService.updateOrder(order, id);
        return ResponseEntity.ok(updateOrder);
    }
    @DeleteMapping("/{idDeleted}")
    public ResponseEntity<Void>  deleteOrder(@PathVariable Long idDeleted) {
        orderService.deleteOrder(idDeleted);
        return ResponseEntity.noContent().build();
    }

}

//    @GetMapping("/{id}")
//    public ResponseEntity<?> findById(@PathVariable Long id) {
//        //? returneaza generice
//        try {
//            Order order = orderService.findById(id);
//            return ResponseEntity.ok(order);
//        } catch (Exception e) {
//            // return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
//            //indica si pathul pe care apare eroarea
//        }
//    }


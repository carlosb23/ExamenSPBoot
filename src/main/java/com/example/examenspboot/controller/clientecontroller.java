package com.example.examenspboot.controller;

import com.example.examenspboot.entity.Cliente;
import com.example.examenspboot.repositorio.RepositorioCliente;
import com.example.examenspboot.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/cliente")
public class clientecontroller {

    @Autowired
    private RepositorioCliente repositorioCliente;
    @Autowired
    private security Security;


    @PostMapping("/post")
    public ResponseEntity<Cliente> nuevo(@RequestBody Cliente cliente, @RequestParam String token) {
        if (security.validateToken(token)) {
            return new ResponseEntity<>(repositorioCliente.save(cliente), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/id/{id}")
    public Cliente getClientePorId(@PathVariable Long id){
        return repositorioCliente.getClienteById(id);
    }

    @GetMapping("/{total}")
    public List<Cliente> getClientesActivosConMayorVenta(@PathVariable Double total){
        return repositorioCliente.getActivosPorVentaMayor(total);
    }

    @GetMapping("/estadisticas")
    public ResponseEntity<Map<String, Object>> getClienteStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("Total de ventas entre los clientes: ", repositorioCliente.getSumaTotales());
        stats.put("Promedio de ventas de los clientes: ", repositorioCliente.getMediaTotalActivos());
        stats.put("Cantidad de clientes inactivos con ventas mayores a 0: ", repositorioCliente.getNumeroClientesInactivos());

        return new ResponseEntity<>(stats, HttpStatus.OK);
    }
}

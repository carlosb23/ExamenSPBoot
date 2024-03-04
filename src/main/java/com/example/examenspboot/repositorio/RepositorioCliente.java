package com.example.examenspboot.repositorio;

import com.example.examenspboot.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositorioCliente extends JpaRepository<Cliente, Long> {

    Cliente getClienteById(Long id);

    @Query("SELECT c FROM Cliente c WHERE c.estado = 'activo' AND c.total > :total")
    List<Cliente> getActivosPorVentaMayor(Double total);

    @Query(value = "SELECT SUM(c.total) FROM Cliente c")
    Integer getSumaTotales();

    @Query("SELECT AVG(c.total) FROM Cliente c WHERE c.estado = 'activo'")
    Double getMediaTotalActivos();

    @Query("SELECT COUNT(c) FROM Cliente c WHERE c.estado = 'inactivo' AND c.total > 0")
    Integer getNumeroClientesInactivos();
}

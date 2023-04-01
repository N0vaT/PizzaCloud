package com.nova.pizzaCloud.repository;

import com.nova.pizzaCloud.models.TacoOrder;
import com.nova.pizzaCloud.models.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<TacoOrder, Long> {

    List<TacoOrder> findByUserOrderByPlacedAtDesc(
            User user, Pageable pageable);

}

package net.akshaath.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.akshaath.springboot.entity.Greeting;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}

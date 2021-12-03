package com.inovus.numbers;

import org.springframework.data.jpa.repository.JpaRepository;

interface NumberRepository extends JpaRepository<Number, Long> {
}

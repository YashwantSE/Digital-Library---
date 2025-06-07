package com.ver.BookLib.repository;

import com.ver.BookLib.model.Txn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface TxnRepository extends JpaRepository<Txn,Integer> {

    @Modifying
    @Transactional
    @Query(value = "insert into txn (created_on, paid_amount, status, txn_id, updated_on, book_id, student_id) VALUES ('2024-01-28 15:45:37.391000', 100, 'ISSUED', '74e82b17-6e17-4236-9956-3d1f3f24e9d6', '2024-01-28 15:45:37.39100', 1, 1)", nativeQuery = true)
    void runMyQuery();

    Txn findByTxnId(String txnId);             // ✅ Custom query on non-primary key
    Optional<Txn> findById(Integer id);
}

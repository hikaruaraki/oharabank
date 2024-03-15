package jp.ac.ohara.oharabank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.ohara.oharabank.model.Oharabank;

@Repository
public interface OharabankRepository extends JpaRepository<Oharabank, Long> {	
}
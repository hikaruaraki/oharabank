package jp.ac.ohara.oharabank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.ohara.oharabank.model.UserModel;

@Repository
public interface LoginRepository extends JpaRepository<UserModel, Long> {

	UserModel findByUsernameEquals(String username);	
}
package jp.ac.ohara.oharabank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.ohara.oharabank.model.Account;
import jp.ac.ohara.oharabank.repository.AccountRepository;

@Service
@Transactional
public class AccountService {

	@Autowired
	private AccountRepository repository;

	/**
	 * 口座一覧の取得
	 * @return List<AddressBook>
	 */
	public List<Account> getAddressList() {
	    List<Account> entityList = this.repository.findAll();
	    return entityList;
	}

	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  AddressBook
	 */
	public Account get(@NonNull Long index) {
		Account account = this.repository.findById(index).orElse(new Account());
		return account;
	}

	/**
	 * 口座の保存
	 * @param AddressBook addressBook
	 */
	public void save(@NonNull Account address) {
		this.repository.save(address);
	}

	/**
	 * 口座データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long index) {
		this.repository.deleteById(index);
	}
}
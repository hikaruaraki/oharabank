package jp.ac.ohara.oharabank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.ohara.oharabank.model.Oharabank;
import jp.ac.ohara.oharabank.repository.OharabankRepository;

@Service
@Transactional
public class OharabankService {

	@Autowired
	private OharabankRepository repository;

	/**
	 * 口座一覧の取得
	 * @return List<AddressBook>
	 */
	public List<Oharabank> getAddressList() {
	    List<Oharabank> entityList = this.repository.findAll();
	    return entityList;
	}

	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  AddressBook
	 */
	public Oharabank get(@NonNull Long index) {
		Oharabank addressBook = this.repository.findById(index).orElse(new Oharabank());
		return addressBook;
	}

	/**
	 * 口座の保存
	 * @param AddressBook addressBook
	 */
	public void save(@NonNull Oharabank address) {
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
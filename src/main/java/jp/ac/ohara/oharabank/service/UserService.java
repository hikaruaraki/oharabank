package jp.ac.ohara.oharabank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.ohara.oharabank.model.UserModel;
import jp.ac.ohara.oharabank.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repository;
	@Autowired
    private PasswordEncoder passwordEncoder;

    

	/**
	 * 口座一覧の取得
	 * @return List<AddressBook>
	 */
	public List<UserModel> getAddressList() {
	    List<UserModel> entityList = this.repository.findAll();
	    return entityList;
	}

	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  AddressBook
	 */
	public UserModel get(@NonNull Long index) {
		UserModel addressBook = this.repository.findById(index).orElse(new UserModel());
		return addressBook;
	}

	/**
	 * 口座の保存
	 * @param AddressBook addressBook
	 */
	public void save(@NonNull UserModel usermodel) {
		usermodel.setPassword(this.passwordEncoder.encode(usermodel.getPassword()));
		this.repository.save(usermodel);
	}

	/**
	 * 口座データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long index) {
		this.repository.deleteById(index);
	}
}
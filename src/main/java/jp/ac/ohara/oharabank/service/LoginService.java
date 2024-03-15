package jp.ac.ohara.oharabank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.ac.ohara.oharabank.model.UserModel;
import jp.ac.ohara.oharabank.repository.LoginRepository;
@Service
public class LoginService implements UserDetailsService {

	@Autowired
	private LoginRepository userRepository; // ユーザモデルのRepository

	/**
	 * ユーザの検索を行う
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("serach username : " + username);
		UserModel user = this.userRepository.findByUsernameEquals(username); // emailで検索するので「EmailEquals」としている
		System.out.println(user.toString());
		return user;
	}
}
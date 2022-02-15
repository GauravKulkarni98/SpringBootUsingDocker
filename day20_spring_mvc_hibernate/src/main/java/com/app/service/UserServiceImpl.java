package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.User;

@Service // to tell SC , that this class contains B.L
@Transactional // to tell SC : to use Tx mgr bean to automatically handle the txs.
public class UserServiceImpl implements IUserService {
	// dependency : DAO layer i/f
	@Autowired
	private IUserDao userDao;

	@Override
	public User authenticateUser(String email, String pass) {
		// TODO Auto-generated method stub
		return userDao.findByEmailAndPassword(email, pass)
				.orElseThrow(() -> new RuntimeException("User login failed : Invalid Credentials"));
	}// after service layer method rets(i.e after @Transactional method rets : tx
		// over --commit(no excs) | rollback (excs)
		// L1 cache is destroyed --pooled out db cn rets to the pool --hib session is
		// closed

}

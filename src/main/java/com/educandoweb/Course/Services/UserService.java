package com.educandoweb.Course.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.Course.Services.Exceptions.DataBaseException;
import com.educandoweb.Course.Services.Exceptions.ResourceNotFoundException;
import com.educandoweb.Course.entities.User;
import com.educandoweb.Course.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		
		//Esse método tenta dar o .Get --> Se nao der lança uma excessao
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
		repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException x) {
			throw new DataBaseException(x.getMessage());
		}
	}
	
	public User update(Long id, User user) {
		User entity = repository.getReferenceById(id);
		updateData(entity,user);
		return repository.save(entity);
		
	}

	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail ());
		entity.setPhone(user.getPhone());	
	}

}

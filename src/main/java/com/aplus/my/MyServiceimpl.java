package com.aplus.my;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyServiceimpl implements MyService{
	@Autowired MyDAO dao;
}

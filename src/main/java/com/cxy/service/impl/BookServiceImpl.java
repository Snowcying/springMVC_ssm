package com.cxy.service.impl;

import com.cxy.controller.Code;
import com.cxy.dao.BookDao;
import com.cxy.domain.Book;
import com.cxy.exception.BusinessException;
import com.cxy.exception.SystemException;
import com.cxy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    public boolean save(Book book) {
        return bookDao.save(book)>0;
//        return true;
    }

    public boolean update(Book book) {
        return bookDao.update(book)>0;

    }

    public boolean delete(Integer id) {
        return bookDao.delete(id)>0;
    }

    public Book getById(Integer id) {
        if (id < 0) {
            throw new BusinessException(Code.BUSINESS_ERR, "业务异常");
        }

        try {
//            int i = 1 / 0;
            return bookDao.getById(id);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_TIMEOUT, "访问超时", e);
        }
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }
}

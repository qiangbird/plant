package dao.impl;

import model.News;

import org.springframework.stereotype.Repository;

import dao.NewsDao;

@Repository("newsDao")
public class NewsDaoImpl extends BaseDaoImpl<News> implements NewsDao {

}

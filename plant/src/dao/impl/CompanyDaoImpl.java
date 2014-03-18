package dao.impl;

import model.Company;

import org.springframework.stereotype.Repository;

import dao.CompanyDao;

@Repository("companyDao")
public class CompanyDaoImpl extends BaseDaoImpl<Company> implements CompanyDao{

}

package controller;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.CompanyService;
import VO.CompanyVo;

@Controller("companyController")
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    
    public void saveCompany(CompanyVo companyVo){
        
        companyService.saveCompany(companyVo);
    }
    
    public void updateCompany(CompanyVo companyVo){
        
        companyService.updateCompany(companyVo);
    }
    
    @ResponseBody
    public JSONObject getCompany(CompanyVo companyVo){
        
        JSONObject company = companyService.getCompany(companyVo);
        
        return company;
    }
    
    public void deleteCompany(CompanyVo companyVo){
        
        companyService.deleteCompany(companyVo);
    }
}

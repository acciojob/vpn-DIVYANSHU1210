package com.driver.services.impl;

import com.driver.model.Admin;
import com.driver.model.Country;
import com.driver.model.CountryName;
import com.driver.model.ServiceProvider;
import com.driver.repository.AdminRepository;
import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository1;

    @Autowired
    ServiceProviderRepository serviceProviderRepository1;

    @Autowired
    CountryRepository countryRepository1;

    @Override
    public Admin register(String username, String password) {
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        adminRepository1.save(admin);
        return admin;
    }

    @Override
    public Admin addServiceProvider(int adminId, String providerName) {
        Admin admin = adminRepository1.findById(adminId).get();
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setName(providerName);
        serviceProvider.setAdmin(admin);
        admin.getServiceProviders().add(serviceProvider);
        adminRepository1.save(admin);
        return admin;
    }


    @Override
    public ServiceProvider addCountry(int serviceProviderId, String countryName) throws Exception{
        if(countryName.length() != 3){
            throw new Exception("Country not found");
        }
        if(countryName.equalsIgnoreCase("ind") || countryName.equalsIgnoreCase("aus") || countryName.equalsIgnoreCase("usa") || countryName.equalsIgnoreCase("chi") || countryName.equalsIgnoreCase("jpn")){
            ServiceProvider serviceProvider = serviceProviderRepository1.findById(serviceProviderId).get();
            Country country = new Country();
            countryName = countryName.toUpperCase();
            if (countryName.equalsIgnoreCase("ind")) {
                System.out.println("country name is"+countryName);
                country.setCountryName(CountryName.IND);
                country.setCode(CountryName.IND.toCode());
            } if (countryName.equalsIgnoreCase("usa")) {
                country.setCountryName(CountryName.USA);
                country.setCode(CountryName.USA.toCode());
            } if (countryName.equalsIgnoreCase("aus")) {
                country.setCountryName(CountryName.AUS);
                country.setCode(CountryName.AUS.toCode());
            } if (countryName.equalsIgnoreCase("chi")) {
                country.setCountryName(CountryName.CHI);
                country.setCode(CountryName.CHI.toCode());
            }if (countryName.equalsIgnoreCase("jpn")) {
                country.setCountryName(CountryName.JPN);
                country.setCode(CountryName.JPN.toCode());
            }
            country.setServiceProvider(serviceProvider);
            serviceProvider.getCountryList().add(country);
            serviceProviderRepository1.save(serviceProvider);
            return serviceProvider;
        }else{
            throw new Exception("Country not found");
        }
    }



//    @Override
//    public ServiceProvider addCountry(int serviceProviderId, String countryName) throws Exception{
//        ServiceProvider serviceProvider = serviceProviderRepository1.findById(serviceProviderId).get();
//
//        Country country = new Country();
//
//        String updatesCountryName = countryName.toLowerCase();
//        if(updatesCountryName.equals("ind")){
//            country.setCountryName(CountryName.IND);
//            country.setCode(CountryName.IND.toCode());
//        } else if (updatesCountryName.equals("aus")) {
//            country.setCountryName(CountryName.AUS);
//            country.setCode(CountryName.AUS.toCode());
//        }else if (updatesCountryName.equals("chi")) {
//            country.setCountryName(CountryName.CHI);
//            country.setCode(CountryName.CHI.toCode());
//        }else if (updatesCountryName.equals("jpn")) {
//            country.setCountryName(CountryName.JPN);
//            country.setCode(CountryName.JPN.toCode());
//        }else if (updatesCountryName.equals("usa")) {
//            country.setCountryName(CountryName.USA);
//            country.setCode(CountryName.USA.toCode());
//        }else throw new Exception("Country not found");
//
//
//        country.setServiceProvider(serviceProvider);
//        serviceProvider.getCountryList().add(country);
//
//        serviceProviderRepository1.save(serviceProvider);
//        return serviceProvider;
//    }
}

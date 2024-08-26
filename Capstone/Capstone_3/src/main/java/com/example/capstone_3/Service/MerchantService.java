package com.example.capstone_3.Service;

import com.example.capstone_3.Api.ApiException;
import com.example.capstone_3.Model.Merchant;
import com.example.capstone_3.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {

    private final MerchantRepository merchantRepository;

    public List<Merchant> getMerchant() {
        return merchantRepository.findAll();
    }

    public void addMerchant(Merchant merchant) {
        merchantRepository.save(merchant);
    }

    public void updateMerchant(Integer id, Merchant merchant) {
        Merchant m = merchantRepository.findMerchantById(id);
        if(m == null) {
            throw new ApiException("Customer with id " + id + " not found");
        }
        m.setEmail(merchant.getEmail());
        m.setPhone(merchant.getPhone());
        m.setOwnerName(merchant.getOwnerName());
        m.setStoreName(m.getStoreName());
        merchantRepository.save(m);
    }

    public void deleteMerchant(Integer id) {
        Merchant m = merchantRepository.findMerchantById(id);
        if ( m == null) {
            throw new ApiException("Customer with id " + id + " not found");
        }
        merchantRepository.delete(m);
    }
}
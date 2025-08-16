package com.example.LearningSpringBoot.service;

import com.example.LearningSpringBoot.DTO.accountsDTO;
import com.example.LearningSpringBoot.Entity.Accounts;
import com.example.LearningSpringBoot.Repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class accountsService {

    @Autowired
    private AccountsRepository accountsRepository;

    public List<accountsDTO> getAllAccountsAsDTO() {
        List<Accounts> accountsList = accountsRepository.findAll();

        return accountsList.stream().map(account -> new accountsDTO(
                account.getAccountNum(),
                account.getAccountType(),
                account.getAccountBalance(),
                account.getAccountOpenDate()
        )).collect(Collectors.toList());
    }
}

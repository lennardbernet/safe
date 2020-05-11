package com.m138.safe;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class PasswortSetService {

    @PersistenceContext
    private EntityManager em;

    public List<PasswortSet> getAllPasswortSetsByUser(User user){
        List<PasswortSet> passwortSetList = em.createNamedQuery("passwortSet.getAllByUser",PasswortSet.class)
                .setParameter(1,user.getId()).getResultList();
        return  passwortSetList;
    }

}

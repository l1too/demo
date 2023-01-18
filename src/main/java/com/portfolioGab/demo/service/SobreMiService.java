package com.portfolioGab.demo.service;

import com.portfolioGab.demo.model.SobreMi;
import com.portfolioGab.demo.repository.SobreMiRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SobreMiService implements ISobreMiService {

    @Autowired
    private SobreMiRepository sobreRepository;

    @Override
    public List<SobreMi> getSobreMis() {
        List<SobreMi> listaSobreMis = sobreRepository.findAll();
        return listaSobreMis;
    }

    @Override
    public void saveSobreMi(SobreMi sobre) {
        sobreRepository.save(sobre);
    }

    @Override
    public void deleteSobreMi(Long id) {
        sobreRepository.deleteById(id);
    }

    @Override
    public SobreMi findSobreMi(Long id) {
        // aca si n o encuentro la persona, devulevo null por eso va el orElse
        SobreMi sobre = sobreRepository.findById(id).orElse(null);
        return sobre;
    }
}

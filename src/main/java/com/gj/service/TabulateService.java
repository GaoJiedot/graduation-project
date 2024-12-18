package com.gj.service;

import com.gj.pojo.Tabulate;
import com.gj.pojo.dto.TabulateDto;
import com.gj.repository.TabulateRepository;
import com.gj.service.iservice.ITabulateService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TabulateService implements ITabulateService {
    @Autowired
    TabulateRepository tabulateRepository;

    @Override
    public Tabulate add(TabulateDto tabulate) {
        Tabulate tabulatePojo = new Tabulate();
        BeanUtils.copyProperties(tabulate, tabulatePojo);
        return tabulateRepository.save(tabulatePojo);
    }

    @Override
    public Tabulate get(Integer tabulateId) {
        return tabulateRepository.findById(tabulateId).orElseThrow(() -> new IllegalArgumentException("List not found"));
    }



    @Override
    public Tabulate update(TabulateDto tabulate) {
        Tabulate tabulatePojo = new Tabulate();
        BeanUtils.copyProperties(tabulate, tabulatePojo);
        return tabulateRepository.save(tabulatePojo);
    }

    @Override
    public void delete(Integer tabulateId) {
        tabulateRepository.deleteById(tabulateId);
    }

    @Override
    public List<Tabulate> getByTabulateName(String tabulateName) {
        return tabulateRepository.findByTabulateName(tabulateName);
    }

    @Override
    public List<Tabulate> getByShopId(Integer shopId) {
        return tabulateRepository.getByShopId(shopId);
    }

    @Override
    public Tabulate uploadTabulateImages(Integer tabulateId, String avatarPath) {
        Tabulate tabulate = tabulateRepository.findById(tabulateId).orElseThrow(() -> new IllegalArgumentException("用户未找到"));
        tabulate.setTabulateImage(avatarPath);
        return tabulateRepository.save(tabulate);
    }

    @Override
    public Page<Tabulate> getByTypeWithPagination(Integer tabulateType, int page, int pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        return tabulateRepository.findByTabulateType(tabulateType, pageRequest);
    }

}
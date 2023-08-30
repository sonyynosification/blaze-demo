package com.example.blazecte;

import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {

  private final EntityManager em;
  private final CriteriaBuilderFactory cbf;
  private final EntityViewManager evm;

  public Page<UserEntityView> findAll(String email, Pageable pageable) {
    var res = evm.applySetting(EntityViewSetting.create(UserEntityView.class), cbf.create(em, UserEntity.class))
        .orderByAsc("id")
        .pageBy(pageable.getPageNumber(), pageable.getPageSize(), "id")
        .getResultList();
    return new PageImpl<>(res, pageable, res.size());
  }
}

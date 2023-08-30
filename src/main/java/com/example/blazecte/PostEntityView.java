package com.example.blazecte;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;

@EntityView(PostEntity.class)
public interface PostEntityView {
  @IdMapping
  String getId();
  String getTitle();
//  UserEntityView getUser();
}

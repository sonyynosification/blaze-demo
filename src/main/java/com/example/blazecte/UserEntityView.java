package com.example.blazecte;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@EntityView(UserEntity.class)
public interface UserEntityView {
  @IdMapping
  String getId();
  String getEmail();
  Set<PostEntityView> getPosts();
}

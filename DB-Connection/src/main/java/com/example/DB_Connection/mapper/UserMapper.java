package com.example.DB_Connection.mapper;

import com.example.DB_Connection.dto.request.UserCreationRequest;
import com.example.DB_Connection.dto.request.UserUpdateRequest;
import com.example.DB_Connection.dto.response.UserResponse;
import com.example.DB_Connection.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring") // generate mapper use for spring
public interface UserMapper {
    User toUser(UserCreationRequest request);

    //    @Mapping(target = "firstname", ignore = false)
//    @Mapping(target = "lastname", ignore = false)
    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}

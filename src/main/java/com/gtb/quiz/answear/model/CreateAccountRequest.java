package com.gtb.quiz.answear.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;

@Data
public class CreateAccountRequest {

    private static long id=2;

    private String name;

    private String avatar;

    private String description;

    private long age;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CreateAccountRequest(@JsonProperty("description") String description,
                                @JsonProperty("name") String name,
                                @JsonProperty("avatar") String avatar,
                                @JsonProperty("age") long age
    ) {
        this.description = description;
        this.name = name;
        this.avatar = avatar;
        this.age=age;
    }

    public User toUser() {
        User user = new User();
        user.setName(this.name);
        user.setAvatar(this.avatar);
        user.setDescription(this.description);
        user.setAge(this.age);
        user.setId(this.id++);
        return user;
    }
}


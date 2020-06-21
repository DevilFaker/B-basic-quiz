package com.gtb.quiz.answear.service;

import com.gtb.quiz.answear.model.CreateAccountRequest;
import com.gtb.quiz.answear.model.CreateEducationRequest;
import com.gtb.quiz.answear.model.Education;
import com.gtb.quiz.answear.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EducationService {

   private Map<Long,List<Education>> educationInfo=new HashMap<>();


    public EducationService() {

        ArrayList<Education> tempInfo=new ArrayList<>();

        tempInfo.add(new Education("Eos, explicabo, nam, tenetur et ab eius deserunt aspernatur ipsum ducimus quibusdam quis voluptatibus."
                                ,2005,"Secondary school specializing in artistic",1));
        tempInfo.add(new Education("Aspernatur, mollitia, quos maxime eius suscipit sed beatae ducimus quaerat quibusdam perferendis? Iusto, quibusdam asperiores unde repellat."
                                ,2009,"First level graduation in Graphic Design",1));

        educationInfo.put(Long.valueOf(1),tempInfo);

        
    }

    public Map<Long,List<Education>> getAllInfo() {
        return educationInfo;
    }

    public List<Education> getInfoByUserId(long id){
        if(educationInfo.containsKey(id)){
            return educationInfo.get(id);
        }
        return null;
    }

    public void creatEducationInfo(CreateEducationRequest createEducationRequest){
        Education education = createEducationRequest.toEducation();
        Long tempId = education.getUserId();
        if(educationInfo.containsKey(tempId)){
            List<Education>info=educationInfo.get(tempId);
            info.add(education);
            educationInfo.replace(tempId,info);
        }else{
            List<Education>tempInfo=new ArrayList<>();
            tempInfo.add(education);
            educationInfo.put(tempId,tempInfo);
        }
    }

//    public void login(User user) {
//
//    }

//    public ResponseEntity<Void> register(CreateAccountRequest createAccountRequest) {
//
//        User newUser = createAccountRequest.toUser();
//
//        if(usersList.contains(newUser)){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
//
//        usersList.add(newUser);
//
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }
}
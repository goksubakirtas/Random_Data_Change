package com.example.Random_Data_Change.user_data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.Random;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

   public List<User> getAllUser(){ return userRepository.findAll();}

   public List<String> getName(){
       List<String> userNames=userRepository.getName();
       return userNames;
   }

    public User getUserById(@PathVariable(value = "id") Long id){
        Optional<User> user=userRepository.findById(id);
        if (!user.isPresent())
            Logger.getLogger("id "+id+" not found" );
        return user.get();
    }

    public User createUser(@Valid @RequestBody User userData){return userRepository.save(userData);}

    public  User updateUser(@PathVariable(value = "id") Long id, @Valid @RequestBody User userRequest){
        User user=getUserById(id);
        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        return userRepository.save(user);
    }

    public void deleteUser(@PathVariable(value = "id") Long id){ userRepository.deleteById(id);}

    public int createRandomNumber(){
        Random  random=new Random();
        return random.nextInt(getAllUser().size());
   }

    public int findDiffNumber(int a){
        int number=createRandomNumber();
        if(a!=number)
            return number;
        else
            return a;
    }

    public List<User> randUserName(){
        List<String> names=userRepository.getName();
        List<User> changedUserList=getAllUser();

        for (User user:changedUserList) {
           int a=createRandomNumber();
            if(!user.getName().equals(names.get(a)))
                user.setName(names.get(a));
            else
                    user.setName(names.get(findDiffNumber(a)));
        }
        return changedUserList;
    }

}

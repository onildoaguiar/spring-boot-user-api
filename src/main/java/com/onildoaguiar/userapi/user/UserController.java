package com.onildoaguiar.userapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Calendar;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signIn")
    @ResponseBody
    public String signIn(User user){
        return "Successfully Sign In";
    }

    @PostMapping("/signUp")
    @ResponseBody
    public User signUp(User userDetails){
        User user = userRepository.save(userDetails);
        return user;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String delete(@PathVariable Long userId){
        userRepository.deleteById(userId);
        return "Successfully deleted";
    }

    @PutMapping("/{id}")
    @ResponseBody
    public User update(@PathVariable Long userId, @Valid  User userDetails){
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setActive(userDetails.getActive());
        user.setEmail(userDetails.getEmail());
        user.setName(userDetails.getName());
        user.setUsername(userDetails.getUsername());
        user.setModifiedAt(Calendar.getInstance().getTime());

        User updatedUser = userRepository.save(user);
        return updatedUser;
    }
}

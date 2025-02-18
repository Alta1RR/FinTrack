package Altakus.FinTrack.service;


import Altakus.FinTrack.model.User;
import Altakus.FinTrack.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository; // Репозиторий для работы с DB

    // Внедрение репозитория через конструктор
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User getUser(Long id){
        return userRepository.findById(id).orElse(null);
    }

    // Проверка на уникальность Email адреса при регистрации нового пользователя
    public User registerUser(User user){
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            return null; // Возвращаем null, если находим email в БД
        }
        else{
            return  userRepository.save(user); // Иначе сохраняем нового пользователя в БД
        }
    }
}

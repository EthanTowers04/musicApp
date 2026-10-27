package EthanTowers.MusicApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import EthanTowers.MusicApp.model.UserAccount;

@Repository 
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
    
}

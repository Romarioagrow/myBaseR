package mybase.mappers;

import mybase.domain.UserAccount;
import mybase.domain.dto.UserAccountDto;
import org.springframework.stereotype.Service;

@Service
public class UserAccountMapper implements UserAccountMapperApi {


    @Override
    public UserAccountDto mapUserAccountEntityToDto(UserAccount userAccount) {

        UserAccountDto userAccountDto = new UserAccountDto();
        userAccountDto.setUserID(userAccount.getUserID());
        userAccountDto.setEmail(userAccount.getEmail());
        userAccountDto.setRegistrationDate(userAccount.getRegistrationDate());
        userAccountDto.setIsEnabled(userAccount.getIsEnabled());
        userAccountDto.setRoles(userAccount.getRoles());

        return userAccountDto;
    }
}

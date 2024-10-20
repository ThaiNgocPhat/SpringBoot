package ra.exercise.service.ss5;

import ra.exercise.dto.ReqRes;

public interface UserService {
    ReqRes signUp(ReqRes request);
    ReqRes signIn(ReqRes request);
    ReqRes refreshToken(ReqRes request);
    ReqRes updateUserInfo(ReqRes request);
    ReqRes changePassword(String oldPassword, String newPassword, String confirmPassword);
}

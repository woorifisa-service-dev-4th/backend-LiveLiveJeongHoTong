package service.validator;

import java.util.*;

public class GuestValidator {
    private List<Integer> validRooms = Arrays.asList(100, 200, 300, 400); // 존재하는 방 번호

    public boolean validateRoomNumber(int roomNumber) {
        return validRooms.contains(roomNumber);
    }

}

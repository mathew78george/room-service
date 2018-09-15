package com.mathew.springboot.services.roomdata;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RoomDataService {
	private static final int COUNT = 100;
	private static List<Room> roomData = new ArrayList<Room>();
	static {
		for (int ii = 1; ii <= COUNT; ii++) {
			Room aRoom = new Room();
			aRoom.setId(ii);
			aRoom.setName("Room-" + ii);
			aRoom.setRoomNumber(String.valueOf(ii));
			aRoom.setBedInfo("BED-" + ii);
			roomData.add(aRoom);
		}
	}

	public List<Room> getRoomData() {
		return roomData;
	}

	public Room getRoomDataByRoomNumber(String roomNumber) {
		int roomIndex = Integer.valueOf(roomNumber);
		if (roomIndex <= 0 || roomIndex > COUNT) {
			return null;
		}
		return roomData.get(Integer.valueOf(roomIndex-1));
	}

}

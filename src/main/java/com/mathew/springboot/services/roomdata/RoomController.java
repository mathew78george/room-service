package com.mathew.springboot.services.roomdata;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "rooms", description = "Data service operations on rooms", tags = ("rooms"))
public class RoomController {

	@Autowired
	private static RoomRepository roomRepo;
	@Autowired
	private RoomDataService roomService;

	@RequestMapping(value = "/rooms", method = RequestMethod.GET)
	@ApiOperation(value = "Get All Rooms", notes = "Gets all rooms in the system", nickname = "getRooms")
	public List<Room> findAllRooms(@RequestParam(name = "roomNumber", required = false) String roomNumber) {
		if (StringUtils.isNotEmpty(roomNumber)) {
			return Collections.singletonList(roomService.getRoomDataByRoomNumber(roomNumber));
		}
		return (List<Room>) roomService.getRoomData();
	}

	public static void autoWireTest() {
		roomRepo.findAll();
	}

	@RequestMapping(value = "teststringfromroomserviceV1", method = RequestMethod.GET)
	public String getTestStringV1(@RequestParam(name = "teststring", required = true) String teststring) {
		System.out.println("Inside getTestString");
		return "Hi From RoomController-->" + teststring;
	}

	@RequestMapping(value = "teststringfromroomservice", method = RequestMethod.GET)
	public String getTestString() {
		System.out.println("Inside getTestString");
		return "Hi From RoomController ";
	}

	@RequestMapping(value = "roombynumber", method = RequestMethod.GET)
	public Room getRoomDataByRoomNumber(@RequestParam(name = "roomNumber", required = true) String roomNumber) {
		System.out.println("Inside getRoomDataByRoomNumber " + roomNumber);
		return roomService.getRoomDataByRoomNumber(roomNumber);
	}

}

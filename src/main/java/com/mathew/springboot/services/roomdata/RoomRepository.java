package com.mathew.springboot.services.roomdata;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

	public Room findByRoomNumber(String roomNumber);

}

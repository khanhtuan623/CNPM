package com.tdt.carrental.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tdt.carrental.dao.ScheduleDao;
import com.tdt.carrental.model.Schedule;

@Service
@Transactional
public class ScheduleServicesImp implements ScheduleServices {

	@Autowired
	private ScheduleDao scheduleDao;
	
	@Override
	public boolean registrationSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		return this.scheduleDao.registrationSchedule(schedule);
	}

	@Override
	public List<Schedule> listSchedule() {
		// TODO Auto-generated method stub
		return this.scheduleDao.listSchedule();
	}

	@Override
	public Boolean updateSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		return this.scheduleDao.updateSchedule(schedule);
	}

	@Override
	public Schedule getSchedule(int id) {
		// TODO Auto-generated method stub
		return this.scheduleDao.getSchedule(id);
	}

	@Override
	public void deleterSchedule(int id) {
		this.scheduleDao.deleteSchedule(id);
		
	}

}

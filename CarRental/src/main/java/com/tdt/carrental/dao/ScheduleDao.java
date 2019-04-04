package com.tdt.carrental.dao;

import java.util.List;

import com.tdt.carrental.model.Schedule;

public interface ScheduleDao {
	public abstract boolean registrationSchedule(Schedule schedule);

	public abstract List<Schedule> listSchedule();

	public abstract Boolean updateSchedule(Schedule schedule);

	public abstract Schedule getSchedule(int id);
}

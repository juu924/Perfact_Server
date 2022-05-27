package com.perfact.server.Controller;

import com.perfact.server.Service.ScheduleService;
import com.perfact.server.dto.Response;
import com.perfact.server.dto.schedule.CreateScheduleDto;
import com.perfact.server.dto.schedule.UpdateScheduleDto;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;


@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedule")
    public Response saveSchedule(@RequestBody CreateScheduleDto createScheduleDto){
         Long schedule = scheduleService.saveSchedule(createScheduleDto);
         return Response.builder()
                 .code("200")
                 .messages("일정 등록이 완료 되었습니다. id = "+schedule)
                 .build();
    }

    //특정 일정만 조회
    @GetMapping("/schedule/{id}")
    public Response searchSchedule(@PathVariable Long id){
        return Response.builder()
                .code("200")
                .messages("일정 조회가 완료되었습니다.")
                .data(Collections.singletonList(scheduleService.getSchedule(id)))
                .build();
    }

    //전체 일정 조회
    @GetMapping("/schedule/list/{id}")
    public Response searchAllSchedule(@PathVariable Long userId){
        return Response.builder()
                .code("200")
                .messages("전체 일정 조회가 완료 되었습니다.")
                .data(Collections.singletonList(scheduleService.getScheduleList(userId)))
                .build();
    }


    @PutMapping("/schedule/{id}")
    public Response updateSchedule(@PathVariable Long id, @RequestBody UpdateScheduleDto updateScheduleDto){
        scheduleService.updateSchedule(id, updateScheduleDto);
        return Response.builder()
                .code("201")
                .messages("일정 수정이 완료되었습니다.")
                .data(Collections.singletonList(scheduleService.getSchedule(id)))
                .build();

    }

    @DeleteMapping("/schdule/{id}")
    public Response deleteSchedule(@PathVariable Long id){
        scheduleService.deleteSchedule(id);
        return Response.builder()
                .code("200")
                .messages("일정 삭제가 완료되었습니다.")
                .build();
    }


}

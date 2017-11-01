package com.capitalone.dashboard.rest;

import com.capitalone.dashboard.request.PerfReviewRequest;
import com.capitalone.dashboard.response.PerfReviewResponse;
import com.capitalone.dashboard.service.PerfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.capitalone.dashboard.misc.HygieiaException;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;

/**
 * Created by gyf420 on 11/1/17.
 */
@RestController
public class PerfController {


    private final PerfService perfService;

    public PerfController(){

        perfService = null;
    }

    public PerfController(PerfService perfService) {
        this.perfService = perfService;
    }




    @RequestMapping(value = "/perfreview", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PerfReviewResponse> perfreview(@Valid PerfReviewRequest request) throws HygieiaException {
        PerfReviewResponse perfReviewResponse = perfService.getresultsBycomponetAndTime(request.getBusinessComponentName(),request.getRangeFrom(),request.getRangeTo());
        return ResponseEntity.ok().body(perfReviewResponse);
    }
}

package com.example.helpdeskticketingsystem.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public interface ReportGenerator <T>{
    ByteArrayInputStream generate(List<T> data) throws IOException;
}

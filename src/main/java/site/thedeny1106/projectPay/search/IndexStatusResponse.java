package site.thedeny1106.projectPay.search;

import java.util.Map;

public record IndexStatusResponse(boolean exists, Map<String, Object> settings, Map<String, Object> mapping)
{}

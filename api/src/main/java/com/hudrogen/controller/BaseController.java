package com.hudrogen.controller;

import org.pf4j.ExtensionPoint;

public interface BaseController extends ExtensionPoint {

    String calcMetric();

    String getMetric();
}

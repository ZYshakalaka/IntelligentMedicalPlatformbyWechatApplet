var wxCharts = require('../../../utils/wxcharts.js');
var app = getApp();
var lineChart = null;
Page({
  data: {
    user_id: '',
    rate1: '',
    rate2: '',
    rate3: '',
    rate4: '',
    rate5: '',
    time1: '',
    time2: '',
    time3: '',
    time4: '',
    time5: '',
  },
  touchHandler: function (e) {
    console.log(lineChart.getCurrentDataIndex(e));
    lineChart.showToolTip(e, {
      background: '#7cb5ec'
    });
  },
  btn: function () {
    wx.switchTab({
      url: '../homepage',
    })
  },
  createSimulationData: function () {
    var categories = [];
    var data = [];
    categories.push(this.data.time1);
    categories.push(this.data.time2);
    categories.push(this.data.time3);
    categories.push(this.data.time4);
    categories.push(this.data.time5);
    data.push(this.data.rate1);
    data.push(this.data.rate2);
    data.push(this.data.rate3);
    data.push(this.data.rate4);
    data.push(this.data.rate5);
    return {
      categories: categories,
      data: data
    }
  },
  onLoad: function (e) {
    var windowWidth = 320;
    try {
      // var res = wx.getSystemInfoSync();
      // windowWidth = res.windowWidth;
    } catch (e) {
      console.error('getSystemInfoSync failed!');
    }
    var that = this;
    this.setData({
      rate1: e.rate1,
      rate2: e.rate2,
      rate3: e.rate3,
      rate4: e.rate4,
      rate5: e.rate5,
      time1: e.time1,
      time2: e.time2,
      time3: e.time3,
      time4: e.time4,
      time5: e.time5,
    });
    var simulationData = this.createSimulationData();
    lineChart = new wxCharts({
      canvasId: 'lineCanvas',
      type: 'line',
      categories: simulationData.categories,
      animation: true,
      background: '#f5f5f5',
      series: [{
        name: '心率',
        data: simulationData.data,
        // format: function (val, name) {
        //   return val.toFixed(2) + '°';
        // }
      }],
      xAxis: {
        disableGrid: true
      },
      yAxis: {
        title: '心率',
        format: function (val) {
          return val.toFixed(2);
        },
        min: 0
      },
      width: windowWidth,
      height: 180,
      dataLabel: true,
      dataPointShape: true,
      extra: {
        lineStyle: 'curve'
      }
    });
  }
});
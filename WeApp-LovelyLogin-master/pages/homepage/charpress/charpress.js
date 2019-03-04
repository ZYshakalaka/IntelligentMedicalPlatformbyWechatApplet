var wxCharts = require('../../../utils/wxcharts.js');
var app = getApp();
var lineChart = null;
Page({
  data: {
    user_id: '',
    user_press_l1: '',
    user_press_l2: '',
    user_press_l3: '',
    user_press_l4: '',
    user_press_l5: '',
    user_press_h1: '',
    user_press_h2: '',
    user_press_h3: '',
    user_press_h4: '',
    user_press_h5: '',
    time1: '',
    time2: '',
    time3: '',
    time4: '',
    time5: '',
  },
  touchHandler: function (e) {
    console.log(lineChart.getCurrentDataIndex(e));
    lineChart.showToolTip(e, {
      // background: '#7cb5ec'
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
    data.push(this.data.user_press_l1);
    data.push(this.data.user_press_l2);
    data.push(this.data.user_press_l3);
    data.push(this.data.user_press_l4);
    data.push(this.data.user_press_l5);
    return {
      categories: categories,
      data: data
    }
  },
  createSimulationData2: function () {
    var categories = [];
    var data = [];
    categories.push(this.data.time1);
    categories.push(this.data.time2);
    categories.push(this.data.time3);
    categories.push(this.data.time4);
    categories.push(this.data.time5);
    data.push(this.data.user_press_h1);
    data.push(this.data.user_press_h2);
    data.push(this.data.user_press_h3);
    data.push(this.data.user_press_h4);
    data.push(this.data.user_press_h5);
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
      user_press_l1: e.user_press_l1,
      user_press_l2: e.user_press_l2,
      user_press_l3: e.user_press_l3,
      user_press_l4: e.user_press_l4,
      user_press_l5: e.user_press_l5,
      user_press_h1: e.user_press_h1,
      user_press_h2: e.user_press_h2,
      user_press_h3: e.user_press_h3,
      user_press_h4: e.user_press_h4,
      user_press_h5: e.user_press_h5,
      time1: e.time1,
      time2: e.time2,
      time3: e.time3,
      time4: e.time4,
      time5: e.time5,
    });
    var simulationData = this.createSimulationData();
    var simulationData2 = this.createSimulationData2();
    lineChart = new wxCharts({
      canvasId: 'lineCanvas',
      type: 'line',
      categories: simulationData.categories,
      animation: true,
      background: '#f5f5f5',
      series: [{
        name: '舒张压',
        data: simulationData.data,
        // format: function (val, name) {
        //   return val.toFixed(2) + '°';
        // }
      }, {
        name: '收缩压',
        data: simulationData2.data,
        // format: function (val, name) {
        //   return val.toFixed(2) + '°';
        // }
      }
      ],
      xAxis: {
        disableGrid: true
      },
      yAxis: {
        title: '血压',
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
var wxCharts = require('../../../utils/wxcharts.js');
var app = getApp();
var lineChart = null;
Page({
    data: {
      user_id: '',
      tem1: '',
      tem2: '',
      tem3: '',
      tem4: '',
      tem5: '',
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
    createSimulationData: function () {
        var categories = [];
        var data = [];
        categories.push(this.data.time1);
        categories.push(this.data.time2);
        categories.push(this.data.time3);
        categories.push(this.data.time4);
        categories.push(this.data.time5);
        data.push(this.data.tem1);
        data.push(this.data.tem2);
        data.push(this.data.tem3);
        data.push(this.data.tem4);
        data.push(this.data.tem5);
        return {
            categories: categories,
            data: data
        }
    },
    btn: function () {
      wx.switchTab({
        url: '../homepage'
      })
    },
    onLoad: function (e) {
        var windowWidth = 320;
        // try {
        //     // var res = wx.getSystemInfoSync();
        //     // windowWidth = res.windowWidth;
        // } catch (e) {
        //     console.error('getSystemInfoSync failed!');
        // }
        var that = this;
        this.setData({
          tem1: e.tem1,
          tem2: e.tem2,
          tem3: e.tem3,
          tem4: e.tem4,
          tem5: e.tem5,
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
                name: '温度',
                data: simulationData.data,
                // format: function (val, name) {
                //     return val.toFixed(2) + '°';
                // }
            }],
            xAxis: {
                disableGrid: true
            },
            yAxis: {
                title: '温度',
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
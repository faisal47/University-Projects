import numpy as np
import matplotlib.pyplot as plt
import matplotlib.cm as cm

x = []
y = []
cnt=0
colors = ["r", "b", "g","c","k","m","y"]
with open('cluster_output.txt') as f:
    for line in f:
        data = line.split()
        if len(data) == 1:
            plt.scatter(x,y,color=colors[cnt])
            cnt=cnt+1
            x=[]
            y=[]
            continue
        x.append(int(data[0]))
        y.append(int(data[1]))
        
plt.scatter(x,y,color=colors[cnt])
cnt=cnt+1
plt.title('start vs unique_count cluster output')
plt.legend()
plt.show()

import os
from resizeimage import resizeimage


directory = r'../src/main/resources/com/Emotes/'
for filename in os.listdir(directory):
    arr = filename.split(".")
    f = open("generated.txt", "a")
    f.write(arr[0].upper()+ '(' + '"' +arr[0].lower() + '"' +  "," + '"' + arr[0] +  '"' + '),' + "\n")

    f.close()

for filename in os.listdir(directory):
    arr = filename.split(".")
    f = open("other.txt", "a")
    f.write("|![" + arr[0] +"](" + "/src/main/resources/com/Emotes/"+ filename + ")" + "|" + arr[0] + "|" + "\n")

    f.close()

